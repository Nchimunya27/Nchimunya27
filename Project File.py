import random

def print_intro():
    """This is a print function"""
    print('Welcome!!')
    print('Are you ready for a Coding Revision Quiz?!')
    
def question_randomiser():
    """ This function picks a random question number and returns it"""
    #Generates random question numbers for the quiz
    question_num = random.randint(1, 10)
    return question_num
    
def question_generator():
    """Function generates the question, prompts the user to input and prints the final outcome"""
    print('Choose the best answer. either 1 or 2.')
    print()
    
    #Dictionary containing questions and respective numbers
    my_question = {
        1 : 'What is a byte comprised of?\n 1. 8 bits\n 2. 4 bits', 
        2 : '1024 bytes make a kilobyte.\n 1. True \n 2. False',
        3 : 'The code 20 * 40 is an expression.\n 1. True \n 2. False',
        4 : 'Comments are required in a program.\n 1. True \n 2. False',
        5 : ' x = 1. Is this assignment valid or invalid?\n 1. Invalid \n 2. Valid',
        6 : ' x + y = y + x. Is this assignment valid or invalid?\n 1. Invalid \n 2. Valid',
        7 : 'Python string objects are mutable. \n 1. True \n 2. False',
        8 : 'A dictionary value can accsessed by indexing.\n 1. True \n 2. False',
        9 : 'Lists are immutable.\n 1. True \n 2. False',
        10: 'A print function must return the value that was output.\n 1. True \n 2. False'
        }
    
    #Dictionary which contains correct answers mapped to questions 
    my_answer_key = {
        1 : 1, 
        2 : 1, 
        3 : 1, 
        4 : 2, 
        5 : 2, 
        6 : 1, 
        7 : 2, 
        8 : 2, 
        9 : 1, 
        10 : 2
        }
    #This is used to count the number of questions answered correctly.
    score = 0
    #This is used to make the loop iterate 10 times.
    count = 0
    #This is used to store the question numbers of questions that have already been printed/asked
    asked_questions = []
    
    while count < 10:
        #Calls the randomising function
        question_num = question_randomiser()
        
        #This helps ensure questions that have already been asked/printed are not printed again
        if question_num in asked_questions:
            continue
        #Prints questions
        print(my_question[question_num])
        
        #makes sure that only integers are entered
        try:
            answer = int(input('Enter 1 or 2 here: '))
        
            #If/else condition validates the user input
            if answer == 1 or answer == 2:
                
                correct_ans = my_answer_key[question_num]
            
                #The code below evaluates the user-inputed answered and marks them right or wrong
                if answer == correct_ans:
                    print('Correct!')
                    print()
                    #sums up the total of correct answers
                    score += 1
                    #Adds already output question numbers to the list
                    asked_questions.append(question_num)
                else:
                    print('Wrong! The correct answer is', my_answer_key[question_num])
                    print()
                    asked_questions.append(question_num)
            
            #Code runs when user input is invalid       
            else:
                print('Please enter 1 or 2 only!')
                print()
                print(my_question[question_num])
                #Answers are re-entered in cases of invalid user-input
                answer = int(input('Enter 1 or 2 here: '))
                correct_ans = my_answer_key[question_num]
        
                if answer == correct_ans:
                    print('Correct!')
                    print()
                    #sums up the total of correct answers
                score += 1
            count += 1
        #Procedures an Error message if a non integer value is entered.
        except ValueError:
            print('Wrong value entered! Please enter integers only, 1 or 2!')
            continue
    
    print('Congratulations! You completed your quiz!')
    print('You scored', score, 'out of 10.')
    print()

def flashcard():
    
    """This function creates a user generated dictionary with words
    and defintions which can can be later accessed by the user"""
    
    flash_dict = {}
    
    #makes dictionary based on user inputs
    while True:
        word_input = input("Enter the name of the flashcard : ")
        definition = input("Enter the meaning : ")
        
        print()
        
        flash_dict[word_input] = definition
        while True:
            #input validation
            try:
                option = int(input("Enter 1, to read flashcards. Enter 0, to add new flashcard: "))
        
                if option == 1 or option == 0:
                    break
            
            except ValueError:
                print('Enter intergers only! e.g. 0, or 1')
                continue
        
    #calls the flashcard that the user wants
        if option:
            while True:
                print() 
                word = input('Look up the word : ')
                print(flash_dict[word])
                print()
                choice = int(input("Enter 1 to stop. Enter 0, to read another flashcard: "))
                if choice == 1:
                    break
            break
                    
    return flash_dict

def main():
    '''
    The main portion of your program should be in this
    function.  Other functions should be called from this
    function.
    '''
    decision = int(input('Enter 1 for CMS 120 revision quiz,or 0 to create flashcards: '))
    
    if decision == 1:
        print_intro()
        question_generator()
        
    if decision == 0:
        #Program ends If user does not want to continue
        flashcard()
    
    print("This is my final homework!")

if __name__ == '__main__':
    main()

