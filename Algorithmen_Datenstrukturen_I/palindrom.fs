module palindrom

// check if list l is a "palindrome"
let check_list l =
    let rec ip l1 l2 =
        match (l1,l2) with
        | ([],[])                       -> true
        | (h1::t1, h2::t2) when h1 = h2 -> ip t1 t2
        | _                             -> false 
    in
        ip l (List.rev l)
;;

// check if a string is a palindrome
let check_word word = check_list(Seq.toList word)