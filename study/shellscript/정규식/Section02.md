# Section02
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




