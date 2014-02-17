@call 01-set-params.bat
@echo Running following command
@echo mysql -u %db.username% -p%db.password%  %db.database%  < 51-ALL-seed-data.sql --default-character-set=utf8


mysql -u %db.username% -p%db.password%  %db.database%  < 51-ALL-seed-data.sql --default-character-set=utf8

pause