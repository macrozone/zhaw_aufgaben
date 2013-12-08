# different Sorting algorithm
	
	if Meteor.isClient
		running = false
		tests = [@quicksort, @shellsort]
		
		Session.set "n", 1000
		$chart = {}
		


		mesureTime = (n, algo) ->
			data = @shuffle [0..n]
			startTime = new Date().getTime()
			algo data
			endTime = new Date().getTime()
			endTime - startTime
		
		runTest = (n) ->

			chart = $chart.highcharts()
			for algo, index in tests
				t = mesureTime n, algo
			
				
				chart.series[index].addPoint [n, t]
			
			chart.series[index].addPoint [n, 0.00001*n*Math.log n]
			chart.series[index+1].addPoint [n, 0.000000001*n*n]


		run = ->
			if running
				runTest Math.round Session.get "n"
				Meteor.setTimeout ->
					n = Session.get "n"
					n *= 1.1
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
				series: [
					{name: 'quicksort', data: []}
					{name: "shellsort", data: []}
					{name: "c * n * log(n)", data: []}
					{name: "c * n^2", data: []}

				]
			
		
