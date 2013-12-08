module hanoi
let rec AC n =
    if n = 0 then ""
    else AB(n-1) + " AC " + BC(n-1)
and AB n = 
    if n = 0 then ""
    else AC(n-1)+" AB "+CB(n-1)
and CB n = 
    if n = 0 then ""
    else CA(n-1)+" CB "+AB(n-1)
and CA n = 
    if n=0 then ""
    else CB(n-1) + " CA "+BA(n-1)
and BC n = 
    if n = 0 then ""
    else BA(n-1) + " BC "+AC(n-1)
and BA n = 
    if n=0 then ""
    else BC(n-1) + " BA "+CA(n-1)

