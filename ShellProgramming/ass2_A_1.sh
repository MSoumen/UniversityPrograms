if [ -e $1 ]
then
echo "$1 exist!"
else
touch $1
fi
ls -l $1
