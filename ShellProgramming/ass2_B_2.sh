printf "Enter a preexisting filename : "
read filename
printf "Enter Starting line : "
read startLine
printf "Enter number of lines you want to print : "
read lines
tail -n +$startLine $filename | head -$lines
