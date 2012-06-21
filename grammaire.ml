#load "dynlink.cma";;

#load "camlp4o.cma";;

(*type parametre=string;;
type Affectation = string*string*Parametre;;
type Action = (Affectation|string*Parametre)
type condition_simple= string
type condition_multiple = list condition_simple
type condition = (condition_simple|condition_multiple)*list action
type transition = string*list condition
type tag = string*list action
type etat = string*list tag *list transition
type robot = list etat*)

(*_______________________________________________________________________*)
let transf2 string = Stream.of_string(string);;

let char_to_string c = String.make 1 c;;

(*parseur pour grammaire nom 
nom->(lettre)+
lettre->'a'|..|'z'|'A'|..|'Z'|'0'|..|'9'|'_'|'.' *)

let nom str = 
  let rec nom_aux stream word= match stream with parser
  |[<''a'..'z'|'A'..'Z'|'0'..'9'|'_'|'.'as n;f>]->( nom_aux f (word^(char_to_string n)))
  |[<>]-> word 
  in nom_aux str "" ;;

(*_______________________________________________________________________*)
(*grammaire des parametres
Parametres-> $|nom|(nom ",")*
*)
let rec parametres  = parser
  |[<p=parametre; mp=more_parametre>]->p::mp
  |[<>]->[]
and more_parametre = parser
  |[<'',';p=parametres>]->p
and parametre= parser
  |[<t=tipe;'':';n=nom>]->(t,n)
and tipe str= match str with parser 
  |[<n=nom>]-> n
  |[<>]-> "string";;

(*____________________________________________________________________*)
(*Actions->(Affectations|action "(" Parametres ");"*)

let rec actions  = parser 
  |[<a=action;ma=more_action>]->a::ma
  |[<>]->[]
and more_action = parser 
  |[<'';';acts=actions>]->acts
and action = parser 
  |[<n=nom;''(';p=parametres;'')'>]->(n,p);;

let rec affectations = parser 
  |[<a=affectation;ma=more_affectation>]->a::ma
and more_affectation= parser
  |[<'';';affect=affectations>]->affect
  |[<>]->[]
and affectation = parser 
  |[<n=nom;''<';''-';a=action>]->(n,a);;

(*____________________________________________________________________*)
(*grammaire des conditions*)
let booleen = parser 
  |[<''!'>]->()
  |[<''&';''&'>]->()
  |[<''|';''|'>]->()
  |[<>]->();;
let rec conditions = parser
  |[<booleen;a=action;mc=more_condition>]->a::mc
  |[<>]->[]
and more_condition = parser 
  |[<cm=conditions>]->cm;;

(*_____________________________________________________________________*)
(*grammaire des transitions*)

let transitions = parser
  |[<''t';''r';''a';''n';''s';''i';''t';''i';''o';''n';''{';c=conditions;''}'>]->c;;
(*_____________________________________________________________________*)
(* parseur pour la grammaire etat : 
Etats-> etat more_etat 
more_etat-> $|etats
etat->"etat="^nom"""{"Transitions"}" *)

let rec etats = parser
  |[<e=etat;me=more_etat>]->e::me
  |[<>]->[]
and more_etat = parser
  |[<e=etats>]->e
and etat = parser
  |[<''e';''t';''a';''t';''=';n=nom;''{';t=transitions;''}'>]->(n,t);;

