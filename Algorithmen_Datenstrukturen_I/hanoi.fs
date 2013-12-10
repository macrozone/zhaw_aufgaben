module hanoi


// version with named poles
// move 4 discs from pole A to pole C: hanoi.AC 4
let rec AC n =
    if n = 0 then ""
    else AB(n-1) + " AC " + BC(n-1)
and AB n = 
    if n = 0 then ""
    else AC(n-1) + " AB " + CB(n-1)
and CB n = 
    if n = 0 then ""
    else CA(n-1) + " CB " + AB(n-1)
and CA n = 
    if n = 0 then ""
    else CB(n-1) + " CA " + BA(n-1)
and BC n = 
    if n = 0 then ""
    else BA(n-1) + " BC " + AC(n-1)
and BA n = 
    if n = 0 then ""
    else BC(n-1) + " BA " + CA(n-1)


// version with indices, move 3 discs from pole 0 to pole 2: hanoi.move 3 0 2
let rec move n x y = 
    if n = 0 then "" 
    else move (n-1) x (3-(x+y)) + " " + string(x) + string(y) + move (n-1) (3-(x+y)) y

