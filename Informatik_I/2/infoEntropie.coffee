logWithBase = (base, arg) ->
  if not arg? 
    return (x) -> logWithBase base,x
  Math.log(arg) / Math.log(base)


log2 = logWithBase 2

informationsGehalt = (p) -> -log2 p

infoEntropie = (ps) ->
  entropie = 0;
  entropie+=informationsGehalt(p)*p for p in ps
  entropie
  
module.exports.logWithBase = logWithBase 
module.exports.informationsGehalt = informationsGehalt

module.exports.infoEntropie = infoEntropie
  
  

