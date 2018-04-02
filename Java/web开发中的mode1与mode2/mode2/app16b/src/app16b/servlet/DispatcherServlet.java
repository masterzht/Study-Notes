package app16b.servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app16b.controller.InputProductController;
import app16b.controller.SaveProductController;

/**
 * 所有的请求会分发到这个地方
 */
public class DispatcherServlet extends HttpServlet {
    
    private static final long serialVersionUID = 748495L;

    @Override
    public void doGet(HttpServletRequest request, 
            HttpServletResponse response)
            throws IOException, ServletException {
        process(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws IOException, ServletException {
        process(request, response);
    }

    /**
     * 处理请求
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void process(HttpServletRequest request,
            HttpServletResponse response) 
            throws IOException, ServletException {

        String uri = request.getRequestURI();
        /*
         * uri is in this form: /contextName/resourceName, 
         * for example: /app10a/product_input. 
         * However, in the event of a default context, the 
         * context name is empty, and uri has this form
         * /resourceName, e.g.: /product_input
         */
        //找最后一个/后面的内容
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1); 
        
        String dispatchUrl = null;
        if (action.equals("product_input.action")) {
            //交给业务处理类处理，这里的业务处理包是controller，由他的Inputxx处理
        	InputProductController controller = new InputProductController();
        	//有业务处理后，会先获取业务的内容，然后再返回一个url
        	dispatchUrl = controller.handleRequest(request, response);
        } else if (action.equals("product_save.action")) {
        	SaveProductController controller = new SaveProductController();
        	dispatchUrl = controller.handleRequest(request, response);
        }

        if (dispatchUrl != null) {
            //跳转到这个jsp处理，jsp会把内容填充，然后结果返回
            RequestDispatcher rd = 
                    request.getRequestDispatcher(dispatchUrl);
            rd.forward(request, response);
        }
    }
}
