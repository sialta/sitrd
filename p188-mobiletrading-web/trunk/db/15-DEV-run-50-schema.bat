@call 01-set-params.bat
@echo Run following command
@echo mysql -u %db.username% -p%db.password%  %db.database% < 01-schema.sql


mysql -u %db.username% -p%db.password%  %db.database% < 01-schema.sql
pause