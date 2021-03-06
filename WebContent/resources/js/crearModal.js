var modalWrap=null;
const showModal=(title,componentes)=>{
     if(modalWrap!==null){
    	modalWrap.remove(); 
     }
     
     var aux=`<button type="button" class="btn btn-primary">Save changes</button>`;
	modalWrap= document.createElement('div');
	modalWrap.innerHTML= `
		<div class="modal fade" tabindex="-1">
		<div class="modal-dialog">
		<div class="modal-content">
		<div class="modal-header">
		<h5 class="modal-title">${title}</h5>
		<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		</div>
		<div class="modal-body">
		
		`
		+
		componentes
		+
		`
		</div>
		<div class="modal-footer">
		<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		<button type="button" class="btn btn-primary">Save changes</button>
		</div>
		</div>
		</div>
		</div>
		`;
 
	document.body.append(modalWrap);
	
	var modal= new bootstrap.Modal(modalWrap.querySelector('.modal'));
    modal.show();	
	
}
