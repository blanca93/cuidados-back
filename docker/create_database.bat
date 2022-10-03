@ECHO OFF
if exist ".\oracle-database\LINUX.X64_193000_db_home.zip" (
    cd ".\oracle-database\"
    echo "Building image: Oracle database 19.3.0"
    docker build -t oracle/database-19.3.0 -f Dockerfile .
    echo "Running container: oracle-database-19.3.0"
    docker run --name oracle-database-19.3.0 -p 1521:1521 -d oracle/database-19.3.0
) else (
    echo "Please, copy the file LINUX.X64_193000_db_home.zip to folder 'oracle-database'"
)
