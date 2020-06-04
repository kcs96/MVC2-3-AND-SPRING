package mvc.board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class BoardController extends MultiActionController {
	Logger logger = Logger.getLogger(BoardController.class);
	public BoardLogic boardLogic = null;
	
	public void setBoardLogic(BoardLogic boardLogic) {
		this.boardLogic = boardLogic;
	}
	public ModelAndView boardList(HttpServletRequest req,HttpServletResponse res) {
		logger.info("boardList 호출 성공");
		List<Map<String,Object>> bList = boardLogic.boardList();
		ModelAndView mav = new ModelAndView();
		//   ==> /WEB-INF/jsp/board/boardList.jsp
		//       mav.setViewName("boardList.jsp");  => jsp.jsp
		//   ==> /WEB-INF/jsp/board/boardList.jsp
		mav.setViewName("board/boardList"); //servlet.xml에 해놨다 이미 WEB-INF/jsp/
		mav.addObject("bList",bList);
		return mav;
	}
	public ModelAndView boardList2(HttpServletRequest req,HttpServletResponse res) {
		logger.info("boardList2 호출 성공");
		try {
			res.sendRedirect("boardList.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
