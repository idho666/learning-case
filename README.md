# learning-case

#tidy up docker ps result
docker ps -a --format "table {{.ID}}\t{{.Names}}\t{{.Image}}\t{{.Ports}}"
