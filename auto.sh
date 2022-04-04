
#if [[ $# != 4 ]]
#then
 #       echo "Number of parameters not sufficient"
  #      exit 1
#else
echo "Enter the path :" 
read a 
cd $a

echo "Enter the profile :"
read b
mvn clean install -P$b
echo "Enter branch name :"
read c
echo "File name to be pushed!! all if not"
read d 
git init
if [[ "$c" == *"master" ]]
then
        git checkout master
 #      git pull origin master
if [[ "$d" == *"all" ]]
then
        git add .
        git commit -m "Added all the files to git repository"
	git pull origin master
        git push origin master
else
        git add "$d"
        git commit -m " "$d" file add to the git repository"
        git pull origin master
	git push origin master

fi

elif [[ "$4" != *"master" ]]
then
        
        git checkout -b "$c"
#       git pull origin "$c"
if [[ "$3" == *"all" ]]
then
        git add .
        git commit -m "Added all the files to git repository"
	git pull origin "$c"
        git push origin "$c"

else
#       git add "$3"
        git add .
        git commit -m " "$d" file add to the git repository"
	git pull origin "$c"
        git push origin "$c"

fi

else
        echo "Thankyou"
        exit 1
fi
#fi

