# different Sorting algorithm
	
	if Meteor.isClient
		running = false
		h1 = (i, h) -> Math.pow 2, i
		h2 = (i, h) -> Math.pow(2, i)-1
		h3 = (i, h) -> 3*h + 1
		
		mesureTime = (n, algo) ->
			data = @shuffle [0..n]
			startTime = new Date().getTime()
			algo data
			endTime = new Date().getTime()
			endTime - startTime

		plots = [
			{label: "quicksort", func:(n) => mesureTime n, @quicksort}
			{label: "c * n * log(n)", func: (n) => 0.00001*n*Math.log n}
	#		{label: "shellsort", func:(n) => mesureTime n, (n)-> @shellsort n, h1}
	#		{label: "c * n^2", func:(n) => 0.00000001 * n*n}
		#	(n) -> @shellsort n, h2
		#	(n) -> @shellsort n, h3
			]
		
		Session.set "n", 1000
		$chart = {}
		


		
		
		runTest = (n) ->

			chart = $chart.highcharts()
			for plot, index in plots
				t = plot.func n
				chart.addSeries {name: plot.label, data:[]} unless chart.series[index]?

				chart.series[index].addPoint [n, t]
			
		


		run = ->
			if running
				runTest Math.round Session.get "n"
				Meteor.setTimeout ->
					n = Session.get "n"
					n *= 1.25
					Session.set "n", n
					run()
				,100



		Template.tests.n = -> Math.round Session.get "n"

		Template.tests.events =
			"click .start": ->
				if !running
					running = true
					run()
				else
					running = false


		Template.chart.rendered = ->
		
			$chart = $(this.find(".chart")).highcharts
				chart:
	                zoomType: 'x'
	
				type: "bar"
				title: "Sortings"
				xAxis:
					type: "logarithmic"
					minorTickInterval: 0.1
				yAxis:
					min: 0
					title:
						text: "time taken in ms"
				
			
		
