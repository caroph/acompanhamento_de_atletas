
//Plugin Tabelas Buscar
// Run Datables plugin and create 3 variants of settings
function AllTables() {
	TestTable1();
	TestTable2();
	LoadSelect2Script(MakeSelect2);
}
function MakeSelect2() {
	$('select').select2();
	$('.dataTables_filter').each(
			function() {
				$(this).find('label input[type=text]').attr(
						'placeholder', 'Buscar');
			});
}
$(document).ready(function() {
	// Load Datatables and run plugin on tables 
	LoadDataTablesScripts(AllTables);
	// Add Drag-n-Drop feature
	WinMove();
});