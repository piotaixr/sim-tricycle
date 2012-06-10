#load "dynlink.cma";;

#load "camlp4o.cma";; (* nécessaire pour faire fonctionner le parseur*)

type 'a pile= Pile_vide|Pile_non_vide of 'a*'a pile;;
(*_______________________________________________________________________*)

(* corps du .ml *)
let sommet_pile p = match p with
  |Pile_non_vide(e,p')->e
  |Pile_vide->"";;

let empiler e p = Pile_non_vide(e,p);;
empiler "harry" Pile_vide;;

let depiler p = match p with
  |Pile_non_vide(e,p')->p'
  |Pile_vide->failwith "pile vide";;

let char_to_string c = String.make 1 c;;
char_to_string 'a';;


let lecture_aux fichier = input_line fichier;;
let ecriture_aux sortie  mot = output sortie mot 0 (String.length mot);;
let ecriture_aux_char sortie char = output_char sortie char;;
let transf entree= Stream.of_string(input_line entree);;
let transf2 string = Stream.of_string(string);;

let rec indenter i sortie = 
  while !i>0 do 
    output_char sortie '\t';
    i:=!i-1
  done ;;

(* detect_etat permet quand on a une accolade et que dans le sommet de la pile est un etat de différencier un état d'autre chose par exemple une transition:
exemple etat=norma{
            transition{
            }
       }
*)

let rec detect_etat stream nom = match stream with parser
  |[<'' ';f>]-> detect_etat f nom
  |[<''\t';f>]-> detect_etat f nom
  |[<''a'..'z'|'A'..'Z'|'_'  as n; f>]-> detect_etat f (nom^(char_to_string n))
  |[<''='>]->nom
  |[< >]->nom;;

let rec parseur pile sortie stream detection nom= match stream with parser 
  |[<'' ';f>]->(parseur pile sortie f detection nom);
  |[<''\n';f>]->(parseur pile sortie f detection nom);
  |[<''\t';f>]->(parseur pile sortie f detection nom);
  |[<'';';f>]->(let name = (sommet_pile pile) 
	       in match name with 
		 |"etat"-> ecriture_aux sortie (nom^"\""^"/>");
		  ( ecriture_aux_char sortie '\n');
		  let p=(depiler pile) in (parseur p sortie f detection "")
		 |word->(ecriture_aux sortie ("<"^"/"^word^">"));
		   (ecriture_aux_char sortie '\n');
		   let p=(depiler pile) in (parseur p sortie f detection""))
				  
  
  |[<'',';f>]-> (let name =(sommet_pile pile)
		in match name with
		  |"action"-> ecriture_aux sortie ("<para>"^" "^nom^" "^"</para>");(ecriture_aux_char sortie '\n');(parseur pile sortie f detection "")
		  |post->( parseur pile sortie f detection ""))

  |[<''=';f>]->( let name = nom
		in match name with 
		  |"etat"-> ecriture_aux sortie ("<etat id="^"\""); let p= (empiler "etat" pile) in (parseur p sortie f detection "")
		  |mot ->parseur pile sortie f detection (nom^(char_to_string '=')))

  |[<''(';f>]-> (let name = nom 
		 in match name with
		   |"si"-> ecriture_aux sortie ("<condition nom=");
		     let p= (empiler "condition" pile) in (parseur p sortie f detection "")
		   |post-> ecriture_aux sortie ("<action nom="^"\""^post^"\""^">");(ecriture_aux_char sortie '\n'); let p= (empiler "action" pile) in (parseur p sortie f detection ""))

   |[<'')';f>]->(let name = (sommet_pile pile)
		in match name with 
		  |"condition"-> ecriture_aux sortie ("\""^nom^"\""^">");
		    (ecriture_aux_char sortie '\n');
		    (parseur pile sortie f detection "")
		  |"action"-> ecriture_aux sortie ("<para>"^" "^nom^" "^"</para>");
		    (ecriture_aux_char sortie '\n');
		    (parseur pile sortie f detection "")
		  |post->parseur pile sortie f detection "")

  |[<''a'..'z'|'A'..'Z'|'_'  as n; f>] -> parseur pile sortie f detection (nom^(char_to_string n))

  |[<''}';f>]->let name = (sommet_pile pile)
	     in (ecriture_aux sortie ("<"^"/"^name^">"));
	       (ecriture_aux_char sortie '\n');
	     let p=(depiler pile) in (parseur p sortie f detection "")
				  
  |[<''{';f>]->  (let name = nom 
		  in match name with
		    |"sinon"->ecriture_aux sortie ("<condition nom="^"\""^"true"^"\""^">");
		      (ecriture_aux_char sortie '\n');
		      let p= (empiler "condition" pile) in (parseur p sortie f detection"")

		    |""->parseur pile sortie f detection ""

		    |post-> if ((detect_etat detection "")="etat")
		      then (ecriture_aux sortie (post^"\""^">");
		      (ecriture_aux_char sortie '\n');
		      (parseur pile sortie f detection""))

		      else (ecriture_aux sortie ("<"^post^">");
			    (ecriture_aux_char sortie '\n');
			    let p= (empiler post pile) in (parseur p sortie f detection "")))

   |[< >]->pile;;


let analyse () = 
  let entree = open_in "automate.txt"
  in let sortie = open_out "test.xml" 
	in if ((lecture_aux entree)<>"/*fichier automate*/")
	  then (failwith "erreur de fichier")
	  else (ecriture_aux sortie ("<?xml version="^"\""^"1.0"^"\""^" encoding='ISO-8859-1' standalone='yes' ?>");
		ecriture_aux_char sortie ('\n');
	    let lect = (lecture_aux entree)
	       in  let rec boucle pile lect = match lect with
		 |"fin"->()
		 |mot->let p=(parseur pile sortie(transf2 mot) (transf2 mot) "")
			in (boucle p (lecture_aux entree))
		  in boucle Pile_vide lect);
     close_out sortie;
     close_in entree;;

analyse();;

(*__________________________________________________________________________*)

(* test pour transformation de fonction *)

(*
let entree = open_in "automate.txt";;
let sortie = open_out "test";;
lecture_aux entree;;
let transf entree= Stream.of_string(input_line entree);;
parseur sortie (transf fichier) "";;
let ecriture_aux sortie  mot = output sortie mot 0 (String.length mot);;
ecriture_aux sortie "blabla";;

let accolade pile sortie f nom = match nom with
  |"sinon"->ecriture_aux sortie ("<condition nom="^"\""^"true"^"\""^">");
    (ecriture_aux_char sortie '\n');
    let p= (empiler "condition" pile) in (parseur p sortie f "")

  |""->parseur pile sortie f ""

  |post-> ecriture_aux sortie ("<"^post^">");
    (ecriture_aux_char sortie '\n');
    let p= (empiler post pile) in (parseur p sortie f "");;


close_out sortie;;
close_in entree;;
*)
(*______________________________________________________________________*)

