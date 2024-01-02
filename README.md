# learning-case

#tidy up docker ps result
docker ps -a --format "table {{.ID}}\t{{.Names}}\t{{.Image}}\t{{.Ports}}"


=========================================================================
# create container posgres image 
docker run --name my-postgres-container -e POSTGRES_PASSWORD=mysecretpassword -d -p 5432:5432 postgres

# running postgress docker 
docker exec -it my-postgres-container psql -U postgres -l


