
infoStuff = require './infoEntropie'

console.log "informationsGehalt", (infoStuff.informationsGehalt p for p in process.argv[2..])

console.log "infoEntropie", infoStuff.infoEntropie process.argv[2..]
