

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

(* detect_etat permet quand on a une accolade et que dans le sommet de la pile est un etat de différencier un état d'autre chose par exemple une transition:
exemple etat=norma{
            transition{
            }
       }
*)

let rec detect_condition stream = match stream with parser 
  |[<'' ';f>]->detect_condition f
  |[<''a'..'z'|'A'..'Z'|'_'|'('|')'|','|'{'|'}';f>]->detect_condition f
  |[<''&';''&'>]-> "et"
  |[<''|';''|'>]->"ou"
  |[<''!'>]->"non"
  |[<>]->"";;

let cond_test = transf2("si(bla()||jdr())");;
detect_condition cond_test;;


let rec detect_etat stream nom = match stream with parser
  |[<'' ';f>]-> detect_etat f nom
  |[<''\t';f>]-> detect_etat f nom
  |[<''a'..'z'|'A'..'Z'|'_'  as n; f>]-> detect_etat f (nom^(char_to_string n))
  |[<''='>]->nom
  |[< >]->nom;;

let rec parseur pile sortie stream detection nom piece= match stream with parser 
  |[<'' ';f>]->(parseur pile sortie f detection nom piece);
  |[<''-';f>]->(parseur pile sortie f detection nom piece);
  |[<''\n';f>]->(parseur pile sortie f detection nom piece);
  |[<''\t';f>]->(parseur pile sortie f detection nom piece);
  |[<''!'|'&'|'|';f>]->(parseur pile sortie f detection nom piece);
  |[<''<';f>]-> let p= (empiler "affectation" pile) in (parseur p sortie f detection "" nom)
  |[<'';';f>]->(let name = (sommet_pile pile) 
	       in match name with 
		 |"etat"-> ecriture_aux sortie (nom^"\""^"/>");
		  ( ecriture_aux_char sortie '\n');
		  let p=(depiler pile) in (parseur p sortie f detection "" piece)
		 |"tag"-> ecriture_aux sortie (nom^"\"/>");
		   ecriture_aux_char sortie ('\n');
		   parseur pile sortie f detection "" piece
		 |word->(ecriture_aux sortie ("<"^"/"^word^">"));
		   (ecriture_aux_char sortie '\n');
		   let p=(depiler pile) in (parseur p sortie f detection "" piece))
				  
  
  |[<'',';f>]-> (let name =(sommet_pile pile)
		in match name with
		  |"condition_avec_para"-> if (piece<>"parametre2")
		    then (ecriture_aux sortie (">");
		    ecriture_aux_char sortie '\n';
		    ecriture_aux sortie ("<parametre>"^" "^nom^" "^"</parametre>");
		    ecriture_aux_char sortie '\n';
		    (parseur pile sortie f detection "" "parametre2"))

		 else (ecriture_aux sortie ("<parametre>"^" "^nom^" "^"</parametre>");
		    ecriture_aux_char sortie '\n';
		     (parseur pile sortie f detection "" "parametre2"))

		  |"action"-> ecriture_aux sortie ("<parametre>"^" "^nom^" "^"</parametre>");
		    (ecriture_aux_char sortie '\n');
		    (parseur pile sortie f detection "" piece)
		  |"etat"-> ecriture_aux sortie ("<tag nom=\""^nom^"\"/>");
		    (ecriture_aux_char sortie '\n');
		    (parseur pile sortie f detection "" piece)
		  |"type"->(ecriture_aux sortie (nom^"</parametre>");
			    ( ecriture_aux_char sortie '\n');
			    let p=(depiler pile) in (parseur p sortie f detection"" piece))
		  |post->( parseur pile sortie f detection "" piece))

  |[<''=';f>]->( let name = nom
		in match name with 
		  |"etat"-> ecriture_aux sortie ("<etat id="^"\"");
		    let p= (empiler "etat" pile) in (parseur p sortie f detection "" piece)
		  |"tag"->ecriture_aux sortie ("<tag nom=\"");
		    let p= (empiler "tag" pile) in (parseur p sortie f detection "" piece)
		  |mot ->if ((sommet_pile pile)="tag")
		    then (ecriture_aux sortie ("<action nom=\""^mot^"\" val=\"");
			  parseur pile sortie f detection "" piece)
			  else (parseur pile sortie f detection (nom^(char_to_string '=')) piece))

  |[<'':';f>]->if ((sommet_pile pile)="condition_avec_para")
    then ((ecriture_aux sortie (">"));
	  (ecriture_aux_char sortie '\n');
	 (ecriture_aux sortie ("<parametre type=\""^nom^"\">"));
	   let p= (depiler pile) in (parseur (empiler "type" p) sortie f detection "" piece))
	  else  ((ecriture_aux sortie ("<parametre type=\""^nom^"\">"));
	   let p= (empiler "type" pile) in (parseur p sortie f detection "" piece))

  |[<''(';f>]-> (let word=(sommet_pile pile)
		in match word with 

		  |"affectation"-> ecriture_aux sortie ("<action nom=\""^nom^"\" dest=\""^piece^"\">");
		    (ecriture_aux_char sortie '\n');  
		    let p=(depiler pile) in (parseur (empiler "action" p) sortie f detection"" piece)

		  |autre-> (let name = nom 
			   in match name with
			     |"si"-> let cond = detect_condition detection
				     in if (cond<>"")
				       then ((ecriture_aux sortie ("<condition type=\"multiple\" nom=\""^cond^"\">"));
					     (ecriture_aux_char sortie '\n');
					     let p=(empiler "condition" pile) in (parseur p sortie f detection "" "condition_multiple"))
 
				       else ((ecriture_aux sortie ("<condition nom="));
					      let p= (empiler "condition" pile) in (parseur p sortie f detection "" "si"))

			     |post->(let item = piece
				     in match item with 
				       |"si"->(ecriture_aux sortie ("\""^post^"\""));
					 let p = (empiler "condition_avec_para" pile)  in (parseur p sortie f detection "" piece)

				       |"condition_multiple"->(* (ecriture_aux sortie ("<condition nom=\""^post^"\""));*)
					 let p= (empiler "condition" pile) in (parseur p sortie f detection "" "parametre")

				       |inconnu->(ecriture_aux sortie ("<action nom="^"\""^post^"\""^">"));
						   (ecriture_aux_char sortie '\n'); 
						   let p= (empiler "action" pile) in (parseur p sortie f detection "" piece))))
		
   |[<'')';f>]->(let name = (sommet_pile pile)
		in match name with 
		  |"condition_avec_para"-> if (nom="")
		    then ((ecriture_aux sortie ("/>")); 
			  (ecriture_aux_char sortie '\n');
		    let p= (depiler pile) in(parseur p sortie f detection "" "sans_parametre"))
		    else (
		      if (piece="si")
		      then ((ecriture_aux sortie (">"));
			  (ecriture_aux_char sortie ('\n'));
			  (ecriture_aux sortie ("<parametre>"^" "^nom^" "^"</parametre>"));
			  (ecriture_aux_char sortie ('\n'));
			  let p = (depiler pile) in (parseur p sortie f detection "" "parametre"))
		      else (
			(ecriture_aux sortie ("<parametre>"^" "^nom^" "^"</parametre>"));
			( ecriture_aux_char sortie '\n');
			(let p = (depiler pile) in (parseur p sortie f detection "" "parametre"))))

		  |"condition"->(let word = piece 
				 in match word with 
				   |"sans_parametre"-> parseur pile sortie f detection "" ""
				   |"parametre"-> ecriture_aux sortie ("</condition>");
				     ecriture_aux_char sortie '\n';
				     (parseur pile sortie f detection "" "")
				     
				   |autre-> (ecriture_aux sortie ("\""^nom^"\""^"/>");
					     (ecriture_aux_char sortie '\n');
					     (parseur pile sortie f detection "" piece)))



		  |"action"-> if (nom="" )
		    then (parseur pile sortie f detection "" piece)
		    else (ecriture_aux sortie ("<parametre>"^" "^nom^" "^"</parametre>");
		    (ecriture_aux_char sortie '\n');
		    (parseur pile sortie f detection "" piece))
		  |"type"->(ecriture_aux sortie (nom^"</parametre>");
			    ( ecriture_aux_char sortie '\n');
			    let p=(depiler pile) in (parseur p sortie f detection"" "parametre"))
		  |post->parseur pile sortie f detection "" piece)

  |[<''[';f>]-> (let name = (sommet_pile pile)
	       in match name with 
		 |"etat"->(ecriture_aux sortie (nom^"\""^">"));
		   (ecriture_aux_char sortie '\n');
		   (parseur pile sortie f detection "" piece)
		 |word-> parseur pile sortie f detection "" piece)

   |[<'']';f>]->ecriture_aux sortie ("<tag nom=\""^nom^"\"/>");
		    (ecriture_aux_char sortie '\n');
		    (parseur pile sortie f detection "" piece)
			      

  |[<''1'..'9'|'a'..'z'|'A'..'Z'|'_'|'.'  as n; f>] -> parseur pile sortie f detection (nom^(char_to_string n)) piece

  |[<''}';f>]->(let name = (sommet_pile pile) 
	       in match name with 
		 |"condition"-> let p=(depiler pile) in (parseur p sortie f detection "" piece)
		 |word-> ecriture_aux sortie ("<"^"/"^word^">");
		   (ecriture_aux_char sortie '\n');
			  let p=(depiler pile) in (parseur p sortie f detection "" piece))

				  
  |[<''{';f>]->  (let name = nom 
		  in match name with
		    |"sinon"->ecriture_aux sortie ("<condition nom="^"\""^"true"^"\""^"/>");
		      (ecriture_aux_char sortie '\n');
		      let p= (empiler "condition" pile) in (parseur p sortie f detection "" "{")

		    |""->parseur pile sortie f detection "" "{"

		    |post-> (let word = (detect_etat detection "")
			    in match word with
			      |"tag"->ecriture_aux sortie (post^"\""^">");
				(ecriture_aux_char sortie '\n');
				(parseur pile sortie f detection"" "{")

			      |"etat"-> ecriture_aux sortie (post^"\""^">");
				(ecriture_aux_char sortie '\n');
				(parseur pile sortie f detection"" "{")

			      |autre-> ecriture_aux sortie ("<"^post^">");
				(ecriture_aux_char sortie '\n');
				let p= (empiler post pile) in (parseur p sortie f detection "" "{")))

   |[< >]->pile;;


let analyse ent sort = 
  let entree = open_in (ent^".txt")
  in let sortie = open_out (sort^".xml" )
	in if ((lecture_aux entree)<>"/*fichier automate*/")
	  then (failwith "erreur de fichier")
	  else (ecriture_aux sortie ("<?xml version=\"1.0\" encoding='ISO-8859-1' standalone='yes' ?>");
		ecriture_aux_char sortie ('\n');
	    let lect = (lecture_aux entree)
	       in  let rec boucle pile lect = match lect with
		 |"fin"->()
		 |mot->let p=(parseur pile sortie(transf2 mot) (transf2 mot) "" "")
			in (boucle p (lecture_aux entree))
		  in boucle Pile_vide lect);
     close_out sortie;
     close_in entree;;

analyse "automate" "demo";;







