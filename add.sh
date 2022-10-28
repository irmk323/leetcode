#!/bin/bash

git_path="https://github.com/irmk323/leetcode/blob/master/Python/"
leetcode_path="https://leetcode.com/problems/"

# input should be like this, that is the title of leetcode=> 994. Rotting Oranges 
echo Please input the title of problem: 
read title

str=$title
array=(${str//./ })
number=${array[0]}
only_string=`echo $title | sed -E 's/[0-9]+. //g' | sed -E 's/ /-/g' |  tr '[:upper:]' '[:lower:]'`

code_file_link="${git_path}${number}_${only_string}.py"
leetcode_link=$leetcode_path$only_string

# create empty file
cd Python
touch ${number}_${only_string}.py
cd ..

command="gsed -i '4i  | [$title]($leetcode_link) | [Link]($code_file_link) |' README.md"
eval $command