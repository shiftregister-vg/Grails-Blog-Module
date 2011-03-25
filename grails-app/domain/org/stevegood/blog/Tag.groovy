package org.stevegood.blog

class Tag {
	
	String uri
	String label
	
	static belongsTo = [Post]
	static hasMany = [posts:Post]
	
    static constraints = {
		label blank:false, unique:true
    }
	
	static beforeInsert = {
		prepareBean()
	}
	
	void prepareBean(){
		uri = toUri()
	}
	
	String toUri(){
		label.replaceAll(/[^a-z-A-Z0-9]/, '-').replaceAll(/(\-+)/, '-').toLowerCase()
	}
}
