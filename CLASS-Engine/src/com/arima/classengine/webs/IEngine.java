package com.arima.classengine.webs;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dell
 * Date: 11/7/13
 * Time: 1:32 AM
 * To change this template use File | Settings | File Templates.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface IEngine {


    /**
     * A Sample Test Method Returns String "HelloUser".
     *
     * @return
     */
    @WebMethod
    public String sayHelloCLASS();

    /**
     * Insert given students into CLASS Student table.
     *
     * @param jsonCStudentListString A String of JSONArray containing collection of JSONObjects of CStudents.
     * @return A four digits string message code representing the status of the action.
     * @author JayKrish
     */
    @WebMethod
    public String insertStudents(String jsonCStudentListString);

    /**
     * Insert given exam and corresponding students' performance to CLASS database.
     * If exam type is general then it is expected the performance to be results as string.
     * Otherwise, for term exam and continuous assignments performance could be marks as Integer.
     *
     * @param jsonCExamString A String of JSONObject containing exam details and collection of JSONObjects of CPerformance.
     * @return A four digits string message code representing the status of the action.
     * @author JayKrish
     */
    @WebMethod
    public String insertExamPerformance(String jsonCExamString);

    /**
     * @param schoolNo
     * @param grade
     * @param term
     * @param subjects
     * @param marks
     * @return
     */
    @WebMethod
    public ArrayList<Integer> getNearestLocalProfiles(int schoolNo, int grade, int term, List<String> subjects, List<Integer> marks);

    /**
     * @param grade
     * @param term
     * @param subjects
     * @param marks
     * @return
     */
    @WebMethod
    public ArrayList<Integer> getNearestGlobalProfiles(int grade, int term, List<String> subjects, List<Integer> marks);


}
