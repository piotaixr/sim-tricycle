#load "dynlink.cma";;

#load "camlp4o.cma";; (* nécessaire pour faire fonctionner le parseur*)

type 'a pile= Pile_vide|Pile_non_vide of 'a*'a pile;;
(*_______________________________________________________________________*)

(* corps du .ml *)
let sommet_pile p = match p with
  |Pile_non_vide(e,p')->e
  |Pile_vide->failwith "pile vide";;

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

let rec parseur pile sortie stream nom= match stream with parser 
  |[<'' ';f>]->(parseur pile sortie f nom);
  |[<''\n';f>]->(parseur pile sortie f nom);
  |[<''\t';f>]->(parseur pile sortie f nom);
  |[<'',';f>]-> (let name =(sommet_pile pile)
		in match name with
		  |"action"-> ecriture_aux sortie ("<para>"^" "^nom^" "^"</para>");(ecriture_aux_char sortie '\n');(parseur pile sortie f "")
		  |post->pile)

 (* |[<''=';f]->(let name = nom 
	      in match name with
		|"etat"->  ecriture_aux sortie ("<etat id=");
		           (parseur pile sortie f "");
		|mot->parseur pile sortie f(mot^(char_to_string '=')))
 *)
  |[<''(';f>]-> (let name = nom 
		 in match name with
		   |"si"-> ecriture_aux sortie ("<condition nom=");
		     let p= (empiler "condition" pile) in (parseur p sortie f "")
		   |post-> ecriture_aux sortie ("<action nom="^"\""^post^"\""^">");(ecriture_aux_char sortie '\n'); let p= (empiler "action" pile) in (parseur p sortie f ""))

   |[<'')';f>]->(let name = (sommet_pile pile)
		in match name with 
		  |"condition"-> ecriture_aux sortie ("\""^nom^"\""^">");
		    (ecriture_aux_char sortie '\n');
		    (parseur pile sortie f "")
		  |"action"-> ecriture_aux sortie ("<para>"^" "^nom^" "^"</para>");
		    (ecriture_aux_char sortie '\n');
		    ecriture_aux sortie ("</action>");
		    (ecriture_aux_char sortie '\n');
		    let p=(depiler pile) in (parseur p sortie f "")
		  |post->pile)

  |[<''a'..'z'|'A'..'Z'|'_'|'='  as n; f>] -> parseur pile sortie f (nom^(char_to_string n))

  |[<''}';f>]->let name = (sommet_pile pile)
	     in (ecriture_aux sortie ("<"^"/"^name^">"));
	       (ecriture_aux_char sortie '\n');
	     let p=(depiler pile) in (parseur p sortie f "")
				  
  |[<''{';f>]-> (let name = nom 
		in match name with
		  |"sinon"->ecriture_aux sortie ("<condition nom="^"\""^"true"^"\""^">");
		    (ecriture_aux_char sortie '\n');
		    let p= (empiler "condition" pile) in (parseur p sortie f "")

		  |""->parseur pile sortie f ""

		  |post-> ecriture_aux sortie ("<"^post^">");
		    (ecriture_aux_char sortie '\n');
		    let p= (empiler post pile) in (parseur p sortie f ""))
   |[< >]->pile;;


let analyse () = 
  let entree = open_in "pile.txt"
  in let sortie = open_out "test.xml" 
	in if (lecture_aux entree)<>"/*fichier automate*/"
	  then failwith "erreur de fichier"
	  else let lect = (lecture_aux entree)
	       in  let rec boucle pile lect = match lect with
		 |"fin"->()
		 |mot->let p=(parseur pile sortie(transf2 mot) "")
			in (boucle p (lecture_aux entree))
		  in boucle Pile_vide lect;
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


let p nom f =
   let t name k=  match name with
		|"etat"->  ecriture_aux sortie ("<etat id=");
		           (parseur pile sortie k "");
		|mot->(parseur pile sortie k (mot^(char_to_string '=')))
   in (t nom f);;


close_out sortie;;
close_in entree;;
*)
(*______________________________________________________________________*)

(* fonction de base (pour revenir si y a un problème 
objectivement ne sert pas )*)
(*

let rec parseur pile sortie string nom= match string with parser 
  |[<'' '>] ->pile
  |[<''\n'>] ->pile
  |[<''\t';f>]-> (parseur pile sortie f nom)
  |[<''a'..'z'|'A'..'Z'|'('|')'|'='|'_'  as n; f>] -> parseur pile sortie f (nom^(char_to_string n))
  |[<''}';f>]->let name = (sommet_pile pile)
	     in (ecriture_aux sortie ("<"^"/"^name^">"));
	       (ecriture_aux_char sortie '\n');
	     let p=(depiler pile) in (parseur p sortie f "")

  |[<''{';f>]-> ecriture_aux sortie ("<"^nom^">");(ecriture_aux_char sortie '\n');let p= (empiler nom pile) in (parseur p sortie f "")
  |[<>] ->pile;;

let analyse () = 
  let entree = open_in "pile.txt"
  in let sortie = open_out "test.xml" 
	in if (lecture_aux entree)<>"/*fichier automate*/"
	  then failwith "erreur de fichier"
	  else let lect = (lecture_aux entree)
	       in  let rec boucle pile lect = match lect with
		 |"fin"->()
		 |lect->let p=(parseur pile sortie(transf2 lect) "")
			in (boucle p (lecture_aux entree))
		  in boucle Pile_vide lect;
     close_out sortie;
     close_in entree;;

analyse();;
*)
