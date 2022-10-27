#!/bin/bash
git_path="https://github.com/irmk323/leetcode/blob/master/Python/"
leetcode_path="https://leetcode.com/problems/"
echo $git_path
echo Please input the title of problem: 
read title 
#結果を表示
echo $title

leetcode_link=$leetcode_path+$title
command="gsed -i '4i  | [$title]($leetcode_link) | [Link]($git_path) |' README.md"
echo $command
eval $command


