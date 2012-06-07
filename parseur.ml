#load "dynlink.cma";;

#load "camlp4o.cma";; (* nécessaire pour faire fonctionner le parseur*)

let char_to_string c = String.make 1 c;;

let fichier = open_in "automate.txt" ;;(* ouvre le fichier*)

let lecture fichier = input_line fichier;;

let analyse  fichier =
let rec lecture_aux s p = match s with parser
|[<'' '>] -> p
|[<''\n'>] -> p
|[<''0'..'9'|'a'..'z'|'A'..'Z'|'('|')'  as n; f>] -> lecture_aux f (p^(char_to_string n))
|[<>] -> p in lecture_aux fichier "";;


lecture fichier;;
