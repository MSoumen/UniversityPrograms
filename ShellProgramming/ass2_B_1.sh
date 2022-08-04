#$1 $2 $3
#cat $1 $2 > $3
#cat $3
#printf "Input Pattern : "
#read pattern
#printf "Enter filename : "
#read filename
#grep -n $pattern $filename

while [ 1 -lt 2 ]
do
printf "\n\n1. Merge two files into another file\n"
printf "2. Search pattern in a file\n"
printf "3. Exit\n"
printf "Enter your choice : "

read ch
case $ch in
1)
printf "Input file 1 : "
read f1
printf "Input file 2 : "
read f2
printf "Input new filename : "
read f3
cat $f1 $f2 > $f3
cat $f3
;;
2)
printf "Input Pattern : "
read pattern
printf "Enter filename : "
read filename
grep -n $pattern $filename
;;
3)
echo "Exiting .."
exit
;;
*)
echo "Invalid Option! Try again "
;;
esac

done
