#load "dynlink.cma";;

#load "camlp4o.cma";; (* nécessaire pour faire fonctionner le parseur*)

let char_to_string c = String.make 1 c;;

let fichier = open_in "automate.txt" ;;(* ouvre le fichier*)

let lecture fichier = input_line fichier;;
lecture fichier;;

let parseur  fichier =
let rec parseur_aux s p = match s with parser
|[<'' '>] -> p
|[<''\n'>] -> p
|[<''0'..'9'|'a'..'z'|'A'..'Z'|'('|')'  as n; f>] -> parseur_aux f (p^(char_to_string n))
|[<>] -> p in parseur_aux fichier "";;



let rec indenter i sortie = 
  while !i>0 do 
    output_char sortie '\t';
    i:=!i-1
  done ;;

let analyse () = 
  let k = ref 0
  in let i= ref 0
     in let entree = open_in "automate.txt"
	in let sortie = open_out "test" 
	   in  if ((lecture entree)<> "/*automate*/")
	     then failwith "erreur de fichier"
	     else 
	       while ((lecture entree)<> "fin")&&(!i<11) do
		 indenter k sortie;
		 output sortie "ecriture" 0 8;
		 output_char sortie '\n';
		 i:=!i+1;
		 k:=!i
	       done ;
	     while ((lecture entree)<> "fin")&&(!i>0) do
	       k:=!i;
	       indenter k sortie;
	       output sortie "ecriture" 0 8;
	       output_char sortie '\n';
	       i:=!i-1
	     done ;
	   close_out sortie;
	   close_in entree;;


  
analyse();;




let rec fact n = match n with 
  |0->1
  |k->k*(fact (k-1));;
let n =ref 0 in
while fact !n <= 1000 do
  n:=!n+1
done;
!n;;
