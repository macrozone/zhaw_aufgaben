

fibonacci = (n) ->
	if n <=1 then 1 else fibonacci(n-1) + fibonacci(n-2)


fibonacci2 = (n) ->
	last = 0
	current = 1
	temp = 0
	for i in [1..n] 
		temp = current
		current += last
		last = temp

	return current