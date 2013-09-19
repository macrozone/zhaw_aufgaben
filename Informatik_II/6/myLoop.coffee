myLoop = (lowerBound, upperBound, body) ->
	if lowerBound <= upperBound
		body lowerBound
		myLoop lowerBound + 1, upperBound, body


doSome = (i) -> console.log "do something with #{i}"

n = 0
doMore = (i) -> n += i

