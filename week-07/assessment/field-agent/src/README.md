# Project Plan

## Security Clearance
1. [x] Existing Model
2. [x] SecurityClearance Repository
3. [x] - SC findById(){}
4. [x] - List<SC> findAll(){sql query}
5. [x] - SC add(){}
6. [x] - boolean update(){}
7. [x] - boolean delete(){} 
8. [ ] SecurityClearance Service
9. [ ] - findById
10. [ ] - findAll
11. [ ] - add(){}
12. [ ] - update(){}
13. [ ] - delete(){}
14. [ ] - validate(){}
15. [ ]   - no duplicate names
16. [ ]   - delete validate only if security 
17. [ ]   clearance isnt referenced
18. [ ] 
19. [ ] SecurityClearance Controller
20. [ ] GetById
21. [ ] GetAll
22. [ ] GetNames
23. [ ] PostAdd
24. [ ] PutUpdate
25. [ ] DeleteDelete
26. [ ] 
27. [ ] ## Global Err Handling
28. [ ] Controller Class
29. [ ] ResponseEntity
30. [ ] ExceptionHandlers
31. [ ] - BADREQUEST
32. [ ] - CREATED
33. [ ] - CONFLICT
34. [ ] - NO CONTENT
35. [ ]   - For any issues with the request
36. [ ] - NOTFOUND
37. [ ]   - For any data points not found 
38. [ ]   or not existing
39. [ ]   
40. [ ] For all others
41. [ ] - INTERNALSERVERERROR
42. [ ] - "Sorry not sorry" string response for err
43. [ ] 
44. [ ] ## Alias
45. [ ] CREATE OWN MODEL
46. [ ] Repository
47. [ ] - findById(){}
48. [ ]   - left join
49. [ ] - findNames(){}
50. [ ]   - left join
51. [ ] - findAliasPersona(){}
52. [ ]   - left join
53. [ ] - add
54. [ ] - update
55. [ ] - delete
56. [ ] Service
57. [ ] - findById
58. [ ] - findNames
59. [ ] - findPersona
60. [ ] - add
61. [ ] - update
62. [ ] - delete 
63. [ ] Model
64. [ ] - Id
65. [ ] - name
66. [ ] - persona
67. [ ] - List<names>
68. [ ] ## Testing
69. [ ] MockTesting instead of doubles
70. [ ] - Alias testing
71. [ ]   - repo 
72. [ ]   - service
73. [ ] - Security Clearance testing
74. [ ]   - repo
75. [ ]   - service