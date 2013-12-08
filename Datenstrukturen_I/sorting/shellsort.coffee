@shellsort = (a, h_series, first, last) ->
	first = 0 unless first?
	last = a.length-1 unless last?
	
	n = last - first + 1
	h = 1
	i = 0

	while h < n
		for i in [first..last-h]
			e = a[i+h]
			j = i
			while j >= first and e < a[j]
				a[j+h] = a[j]
				j = j-h
			a[j + h] = e
		i++
		h = h_series i,h



