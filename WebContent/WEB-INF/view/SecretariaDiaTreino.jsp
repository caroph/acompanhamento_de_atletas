
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file='/layout/head.jsp'%>

<body>

	<%@include file='/layout/header.jsp'%>

	<div id="main" class="container-fluid">
		<div class="row">
			<%@include file='/layout/navigationSecretaria.jsp'%>
			<!--Start Content-->
			<div id="content" class="col-xs-12 col-sm-10">
				<div id="ajax-content">
					<%@include file="Mensagem.jsp"%>
					<div id="calendar"></div>
					<div id="event_edit_container">
						<form>
							<input type="hidden" />
							<ul>
								<li><span>Dia da Semana: </span><span class="date_holder"></span>
								</li>
								<li><label for="start">Hora início: </label><select
									name="start"><option value="">Selecione</option></select>
								</li>
								<li><label for="end">Hora fim: </label><select name="end"><option
											value="">Selecione</option></select></li>
								<li><label for="title">Equipe: </label><input type="text"
									name="title" /></li>
							</ul>
						</form>
					</div>
				</div>
			</div>
			<!--End Content-->
		</div>
	</div>

	<%@include file="/layout/footer.jsp"%>
	<script src="<%=Constants.JS%>/scriptTables.js"></script>
	<script type='text/javascript'>
		var year = new Date().getFullYear();
		var month = new Date().getMonth();
		var day = new Date().getDate();

		var eventData = {
			options : {
				allowEventDelete : true,
				eventDelete : function(calEvent, element, dayFreeBusyManager,
						calendar, clickEvent) {
					if (confirm('You want to delete this event?')) {
						calendar.weekCalendar('removeEvent', calEvent.id);
					}
				},
				deletable : function(calEvent, element) {
					return calEvent.start > Date.today();
				}
			},
			events : [ {
				'id' : 1,
				'start' : new Date(year, month, day, 12),
				'end' : new Date(year, month, day, 13, 35),
				'title' : 'Lunch with Mike'
			}, {
				'id' : 2,
				'start' : new Date(year, month, day, 14),
				'end' : new Date(year, month, day, 14, 45),
				'title' : 'Dev Meeting'
			}, {
				'id' : 3,
				'start' : new Date(year, month, day + 1, 18),
				'end' : new Date(year, month, day + 1, 18, 45),
				'title' : 'Hair cut'
			}, {
				'id' : 4,
				'start' : new Date(year, month, day - 1, 8),
				'end' : new Date(year, month, day - 1, 9, 30),
				'title' : 'Team breakfast'
			}, {
				'id' : 5,
				'start' : new Date(year, month, day + 1, 14),
				'end' : new Date(year, month, day + 1, 15),
				'title' : 'Product showcase'
			} ]
		};

		$(document)
				.ready(
						function() {
							var $calendar = $('#calendar');
							var id = 10;

							$('#calendar')
									.weekCalendar(
											{
												timeslotsPerHour : 2,
												timeslotHeigh : 60,
												hourLine : true,
												use24Hour : true,
												data : eventData,
												date : new Date(2015, 4, 06),
												minDate : new Date(2015, 4, 03),
												maxDate : new Date(2015, 4, 09),
												title : '',
												businessHours : {
													start : 0,
													end : 0,
													limitDisplay : false
												},
												height : function($calendar) {
													return $(window).height()
															- $('h1')
																	.outerHeight(
																			true);
												},
												dateFormat : "d/m/Y",
												longDays : [ 'Domingo',
														'Segunda', 'Terça',
														'Quarta', 'Quinta',
														'Sexta', 'Sábado' ],
												shortDays : [ 'D', 'S', 'T',
														'Q', 'Q', 'S', 'S' ],
												longMonths : [ '', '', '', '',
														'', '', '', '', '', '',
														'', '' ],
												shortMonths : [ '', '', '', '',
														'', '', '', '', '', '',
														'', '' ],
												showHeader : false,
												eventRender : function(
														calEvent, $event) {
													if (calEvent.end.getTime() < new Date()
															.getTime()) {
														$event
																.css(
																		'backgroundColor',
																		'#aaa');
														$event
																.find('.time')
																.css(
																		{
																			'backgroundColor' : '#999',
																			'border' : '1px solid #888'
																		});
													}
												},
												eventNew : function(calEvent,
														$event) {
													var $dialogContent = $("#event_edit_container");
													resetForm($dialogContent);
													var startField = $dialogContent
															.find(
																	"select[name='start']")
															.val(calEvent.start);
													var endField = $dialogContent
															.find(
																	"select[name='end']")
															.val(calEvent.end);
													var titleField = $dialogContent
															.find("input[name='title']");
													//var bodyField = $dialogContent.find("textarea[name='body']");

													$dialogContent
															.dialog(
																	{
																		modal : true,
																		title : "Novo Horário de Treino",
																		close : function() {
																			$dialogContent
																					.dialog("destroy");
																			$dialogContent
																					.hide();
																			$(
																					'#calendar')
																					.weekCalendar(
																							"removeUnsavedEvents");
																		},
																		buttons : {
																			save : function() {
																				calEvent.id = id;
																				id++;
																				calEvent.start = new Date(
																						startField
																								.val());
																				calEvent.end = new Date(
																						endField
																								.val());
																				calEvent.title = titleField
																						.val();
																				//calEvent.body = bodyField.val();

																				$calendar
																						.weekCalendar("removeUnsavedEvents");
																				$calendar
																						.weekCalendar(
																								"updateEvent",
																								calEvent);
																				$dialogContent
																						.dialog("close");
																			},
																			cancel : function() {
																				$dialogContent
																						.dialog("close");
																			}
																		}
																	}).show();

													$dialogContent
															.find(
																	".date_holder")
															.text(
																	formateWeek(calEvent.start));//$calendar.weekCalendar("formatDate", calEvent.start));
													setupStartAndEndTimeFields(
															startField,
															endField,
															calEvent,
															$calendar
																	.weekCalendar(
																			"getTimeslotTimes",
																			calEvent.start));
												},
												eventDrop : function(calEvent,
														$event) {
													displayMessage('<strong>Evento Movido</strong><br/>Início: '
															+ calEvent.start
															+ '<br/>Fim: '
															+ calEvent.end);
												},
												eventResize : function(
														calEvent, $event) {
													displayMessage('<strong>Evento Alterado</strong><br/>Início: '
															+ calEvent.start
															+ '<br/>Fim: '
															+ calEvent.end);
												},
												eventClick : function(calEvent,
														$event) {
													if (calEvent.readOnly) {
														return;
													}

													var $dialogContent = $("#event_edit_container");
													resetForm($dialogContent);
													var startField = $dialogContent
															.find(
																	"select[name='start']")
															.val(calEvent.start);
													var endField = $dialogContent
															.find(
																	"select[name='end']")
															.val(calEvent.end);
													var titleField = $dialogContent
															.find(
																	"input[name='title']")
															.val(calEvent.title);
													var bodyField = $dialogContent
															.find("textarea[name='body']");
													bodyField
															.val(calEvent.body);

													$dialogContent
															.dialog(
																	{
																		modal : true,
																		title : "Editar Horário de Treino",
																		close : function() {
																			$dialogContent
																					.dialog("destroy");
																			$dialogContent
																					.hide();
																			$(
																					'#calendar')
																					.weekCalendar(
																							"removeUnsavedEvents");
																		},
																		buttons : {
																			save : function() {

																				calEvent.start = new Date(
																						startField
																								.val());
																				calEvent.end = new Date(
																						endField
																								.val());
																				calEvent.title = titleField
																						.val();
																				calEvent.body = bodyField
																						.val();

																				$calendar
																						.weekCalendar(
																								"updateEvent",
																								calEvent);
																				$dialogContent
																						.dialog("close");
																			},
																			"delete" : function() {
																				$calendar
																						.weekCalendar(
																								"removeEvent",
																								calEvent.id);
																				$dialogContent
																						.dialog("close");
																			},
																			cancel : function() {
																				$dialogContent
																						.dialog("close");
																			}
																		}
																	}).show();

													var startField = $dialogContent
															.find(
																	"select[name='start']")
															.val(calEvent.start);
													var endField = $dialogContent
															.find(
																	"select[name='end']")
															.val(calEvent.end);
													$dialogContent
															.find(
																	".date_holder")
															.text(
																	formateWeek(calEvent.start));//$calendar.weekCalendar("formatDate", calEvent.start));
													setupStartAndEndTimeFields(
															startField,
															endField,
															calEvent,
															$calendar
																	.weekCalendar(
																			"getTimeslotTimes",
																			calEvent.start));
													$(window).resize().resize();
												}
											});

							function displayMessage(message) {
								$('#message').html(message).fadeIn();
							}

							function formateWeek(d) {
								var weekday = new Array(7);
								weekday[0] = "Domingo";
								weekday[1] = "Segunda";
								weekday[2] = "Terça";
								weekday[3] = "Quarta";
								weekday[4] = "Quinta";
								weekday[5] = "Sexta";
								weekday[6] = "Sábado";

								return n = weekday[d.getDay()];
							}

							$('<div id="message" class="ui-corner-all"></div>')
									.prependTo($('body'));

							function resetForm($dialogContent) {
								$dialogContent.find("input").val("");
								$dialogContent.find("textarea").val("");
							}

							function setupStartAndEndTimeFields(
									$startTimeField, $endTimeField, calEvent,
									timeslotTimes) {

								$startTimeField.empty();
								$endTimeField.empty();

								for (var i = 0; i < timeslotTimes.length; i++) {
									var startTime = timeslotTimes[i].start;
									var endTime = timeslotTimes[i].end;
									var startSelected = "";
									if (startTime.getTime() === calEvent.start
											.getTime()) {
										startSelected = "selected=\"selected\"";
									}
									var endSelected = "";
									if (endTime.getTime() === calEvent.end
											.getTime()) {
										endSelected = "selected=\"selected\"";
									}
									$startTimeField
											.append("<option value=\"" + startTime + "\" " + startSelected + ">"
													+ timeslotTimes[i].startFormatted
													+ "</option>");
									$endTimeField
											.append("<option value=\"" + endTime + "\" " + endSelected + ">"
													+ timeslotTimes[i].endFormatted
													+ "</option>");

									$timestampsOfOptions.start[timeslotTimes[i].startFormatted] = startTime
											.getTime();
									$timestampsOfOptions.end[timeslotTimes[i].endFormatted] = endTime
											.getTime();

								}
								$endTimeOptions = $endTimeField.find("option");
								$startTimeField.trigger("change");
							}

							var $endTimeField = $("select[name='end']");
							var $endTimeOptions = $endTimeField.find("option");
							var $timestampsOfOptions = {
								start : [],
								end : []
							};
						});
	</script>
</body>
</html>