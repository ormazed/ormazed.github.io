# Section04. Whitespace Characters and String Boundaries

## Multi-tasking BBackslash (\)
---

`\t` : tap   
`\n` : new line   
`\r` : return   
`\f` : form feed   
`\v` : vertical tap   


> Good to know : Line breaks
>> Windows(\r\n) , MacOS,Linux (\n)

\t 를 사용하여 정규식 내에 공백을 허용할 수 있다.

`/ +.*/` : start with one or more space characters followed by any number of characters that aren't new lines


## String Boundaries
---

`^` : anchor at start of string   
`$` : anchor at end of string   
 
> anchor
>> These tokens don't consume characters
>> They don't amtch a character just indicate where the regex is within the string


/^공란+.*/
`^` : Anchor at the start of the string
`공란+` : One or more space characters
`.*` : Zero or more of any character but newline(\n)
