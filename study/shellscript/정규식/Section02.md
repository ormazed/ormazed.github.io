# Section03
## Quantifiers
`?`
`+`
`*`

some characters have other meanings -> special characters
`.` is a special character too -> "any character except a newline" 

`Kittens\.{1,3}`

`Kittens\.{3}`

`Kittens\.{3,}`


`[0-9A-F]+` : 16진수를 표현하는 방법
[]+:One or more of the characters represented between []

### Character Ranges
---
/[0123456789ABCDEF]+/ = /[0-9A-F]+/   
Use a '-' to create a range



### Negation 
---
`[^]` : anything but hte character in this collection    
(ex) [^a-z4] -> Anything but lowercase letters a through z or the number 4

/[A-Z][^\.?!]+[\.?!]/   
- A ~ Z 까지의 알파뱃으로 시작하는 한 개의 어간   
- 중간에 (. ? ! ) 가 사용되지는 않는다면 뭐가와도 가능 +   
- 마지막에는 (. ? !) 로 끝나면 된다.   
(ex) ABddddC! -> A / BdddddC / !   

##### Exercies
- Match a string that represents a binary number `/[01]+/;`
- Apostrophe is an option for all but the first letter. First letter can be lowercase or capital; othere letters must be lowercase. The word must contain one or more letters. ``
- Match a telephone number of format : 555-555-5555 `/[0-9]{3}-[0-9]{3}-[0-9]{4}/`
- Match strings that are at least six characters and don't contain the letter A (uppercase or lowercase) : /[^aA]{6,}/;








