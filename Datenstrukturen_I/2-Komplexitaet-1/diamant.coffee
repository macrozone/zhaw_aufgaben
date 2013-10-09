n = 23
half = (n-1)/2
matrix = new Array(n)
for column, i in matrix
	matrix[i] = new Array(n)



fillDiamond = (matrix) ->

	fillColumn = (x, y) -> 
		
		matrix[y][half] = "x"
		matrix[y][half+x] = "x"
		matrix[y][half-x] = "x"

	for x in [0..half]
		fillColumn x,x
		fillColumn x,n-x-1


drawMatrix = (matrix) ->
	for row in matrix
		rowString = ""
		for entry in row

			rowString += entry ? " "
		console.log rowString

fillDiamond matrix

drawMatrix matrix