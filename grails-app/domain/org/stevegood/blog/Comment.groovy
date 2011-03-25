package org.stevegood.blog

class Comment {
	
	String author
	String email
	String body
	Post post
	
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [Post]
	
    static constraints = {
		author blank:false
		email  blank:false, email:true
		body   blank:false
    }
	
	static mapping = {
		body type:"text"
	}
}
