echo $1 > temp
words = `wc -w temp`
chars = `wc -m temp`
sapces =  
rm temp
