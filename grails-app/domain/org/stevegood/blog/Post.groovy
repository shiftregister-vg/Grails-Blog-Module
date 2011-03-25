package org.stevegood.blog

class Post {
	
	String uri
	String title
	String summary
	String body
		
	Date dateCreated
	Date lastUpdated
	
	static hasMany = [comments:Comment,tags:Tag]
	
    static constraints = {
		uri		 blank:false, unique:true
		title    blank:false
		summary  blank:false
		body     blank:false
    }
	
	static mapping = {
		body type:"text"
	}
	
	def beforeValidate = {
		prepareBean()
	}
	
	def beforeInsert = {
		prepareBean()
	}
	
	void prepareBean(){
		if (!uri){
			uri = ""
		}
		int copy = 0
		String suffix = ""
		while (uri.equals("")){
			if (Post.findByUri(toUri() + suffix)){
				copy++
				suffix = "-" + (copy as String)
			} else {
				uri = toUri() + suffix
			}
		}
		
		if ((body && body.length()) && (!summary || summary.equals(""))){
			summary = body[0..139].trim() + "..."
		}
	}
	
	String toUri(){
		title.replaceAll(/[^a-z-A-Z0-9]/, '-').replaceAll(/(\-+)/, '-').toLowerCase()
	}
}
