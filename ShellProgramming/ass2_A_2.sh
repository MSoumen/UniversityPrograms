z=`echo "$1 + $2" | bc`
echo "Sum $z"

z=`echo "$1 - $2" | bc`
echo "Minus $z"

z=`echo "$1 * $2" | bc`
echo "Multiplication $z"

z=`printf "scale=2\n$1/$2\n" | bc`
echo "Division $z"

z=`echo "$1 % $2" | bc`
echo "Modulus $z"
