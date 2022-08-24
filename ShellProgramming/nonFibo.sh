#! /usr/bin/bash
if [ $# -le 0 -o $1 -eq 0 ]; then
	echo Usage: "$0" [num]
	echo "where num>0 is the nth non-fibonachhi number"
	exit
fi

mkdir fiboDIR
# creating fibo nums first
fiboFile=fiboDIR/fiboNums
z=`expr "$1" \* 2 + 1`
sh fibo.sh "$z" > "$fiboFile"
# cat "$fiboFile"
# echo ---------
# creating the numbers file
i=0
file=fiboDIR/tempNum
zz=`head -$z $fiboFile|tail -1`
while [ "$i" -le "$zz" ]; do
	echo "$i" >> "$file"
	i=`expr $i + 1`
done
i=1
while read p
do
	# if [ "$i" -le "$1" ]; then
	# echo "------"
	grep -vx "$p" "$file">temp
	mv temp "$file"
	# cat "$file"
	i=`expr "$i" + 1`
	# fi
	# break

done < $fiboFile
	
# cat "$file"
i=1
while read p
do
	if [ "$i" -le "$1" ]; then
	# echo "------"
	echo "$p"
	i=`expr "$i" + 1`
	else
		break
	fi
done < $file

rm -r fiboDIR
