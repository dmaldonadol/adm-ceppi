package cl.ml.ceppi.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import cl.ml.ceppi.web.rest.AuthenticationRest;

/**
 * Servlet implementation class UploadImage
 */
public class UploadImage extends HttpServlet 
{
	private static final Logger LOGGER = Logger.getLogger(AuthenticationRest.class.getCanonicalName());
	private static final long serialVersionUID = 1L;
	private static final int MAX_FILE_SIZE = 50 * 1024;
	private static final int MAX_MEM_SIZE = 4 * 1024;
	private static final String DIRECTORY_FILES = "/u01/home";
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImage() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		LOGGER.info("isMultipart:"+isMultipart);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(MAX_MEM_SIZE); // maximum size that will be stored in memory
		factory.setRepository(new File(DIRECTORY_FILES)); // Location to save data that is larger than maxMemSize.
		ServletFileUpload upload = new ServletFileUpload(factory); // Create a new file upload handler
		upload.setSizeMax( MAX_FILE_SIZE );// maximum file size to be uploaded.
		try
		{ 
			List<FileItem> fileItems = upload.parseRequest(request); // Parse the request to get file items.
			Iterator<FileItem> i = fileItems.iterator();// Process the uploaded file items
			while ( i.hasNext () ) 
			{
				FileItem fi = (FileItem)i.next();
				if ( !fi.isFormField () )	
				{
					
					LOGGER.info("fieldName"+fi.getFieldName());
					LOGGER.info("fileName"+fi.getName());
					LOGGER.info("contentType"+fi.getContentType());
					LOGGER.info("isInMemory"+fi.isInMemory());
					LOGGER.info("sizeInBytes"+fi.getSize());
					
					File file = null;
					if( fi.getName().lastIndexOf("\\") >= 0 ) // Write the file
					{
						file = new File( DIRECTORY_FILES + "/test/"+ fi.getName().substring( fi.getName().lastIndexOf("\\"))) ;
					}
					else
					{
						file = new File( DIRECTORY_FILES + "/test/"+ fi.getName().substring(fi.getName().lastIndexOf("\\")+1)) ;
					}
					fi.write( file ) ;
				}
			}	      
		}
		catch(Exception ex) 
		{
	       LOGGER.error("", ex);
		}
	}

}
