file="fiboNums"
num1=0
num2=1
echo "$num2" > "$file"
if [ "$1" -ge 2 ]
then
	i=2
	while [ "$i" -le "$1" ]; do
		res=`expr "$num1" + "$num2"`
		echo "$res" >> "$file"
		num1="$num2"
		num2="$res"
		i=`expr $i + 1`
	done
fi
cat "$file"
rm "$file"
