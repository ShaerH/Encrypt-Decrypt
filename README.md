# Encrypt-Decrypt
The text file will consist of messages; each line will start with either E (encrypt) or D (decrypt), and a single digit for the number of columns that will be used (or was used) to encrypt the message.
Each message will end with “*.”

The encryption works as follows:
The message is written to a table of n columns of characters, filling one row at a time. 
When the message is completely written to the table, any blank spaces in the array will be filled with a character “rarely used”, such as X, Z, Q. 
The message is then rewritten by reading the table one column  at a time (reading down the columns), giving a permutation of the original message. 
Your program should output the encrypted message to a text file.

The decryption works “in reverse”:
The message is written to a table of n columns of characters, filling one column at a time. 
You will need to calculate the number of rows needed to store the encrypted message.
The message should fill the table completely.
The message will then be rewritten by reading the table one row at a time (left to right order). 
The decrypted measure should then be written to a text file.
