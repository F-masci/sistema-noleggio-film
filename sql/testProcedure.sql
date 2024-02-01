set @var_employee = 'MSCFNC02L04A123P';
set @var_month = 1;
set @var_year = 2024;
set @var_list_days = '5;10;';
set @var_list_hours = '12:00-15:00;13:00-19:00;';
call inserisciTurnoLavoro(
        @var_employee,
        @var_month,
        @var_year,
        @var_list_days,
        @var_list_hours
     );