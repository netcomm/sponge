import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import com.jd.sponge.SpongeThreadPoolExecutor;


public class TestThread {
	public static AtomicInteger theGI = new AtomicInteger(0);
	
	public static void main(String agrs[])
	{
		try
		{
			/*FilePersistence tmpFilePersistence = new FilePersistence("D:/threadPoolTest/");
			SpongeService tmpSpongeService = new SpongeService(tmpFilePersistence);
			SpongeArrayBlockingQueue tmpMyArrayBlockingQueue =
					new SpongeArrayBlockingQueue(500, 100, tmpSpongeService);
			ThreadPoolExecutor tmpThreadPool =
				new ThreadPoolExecutor(10, 50, 60L, TimeUnit.SECONDS,
						tmpMyArrayBlockingQueue);
			tmpMyArrayBlockingQueue.doFetchData(tmpThreadPool);*/
			
			String tmpDir = "D:/threadPoolTest/";
			if (agrs.length > 0)
			{
				tmpDir = agrs[0];
			}
			
			HashMap tmpParmHMap = new HashMap();
			tmpParmHMap.put(SpongeThreadPoolExecutor.FilePersistence_Dir, tmpDir);
			ThreadPoolExecutor tmpThreadPool = SpongeThreadPoolExecutor.generateThreadPoolExecutor(
					10, 50, 60L, TimeUnit.SECONDS, tmpParmHMap);
			
			//Thread.sleep(150000);
			
			int tmpOneTimeCnt = 10000;
			for (int j = 0; j < 1000; j++)
			{
				long tmpStartTime = System.currentTimeMillis();
				for (int i = 0; i < tmpOneTimeCnt; i++)
				{
					try
					{
						tmpThreadPool.execute(new Run1("afdddddddddddddddddddddddd23432fdsafdsafdsafdsafdsafdsafdsafdsafdsfdsafdsafdsad" +
								"dfdsafdsafdsafdsafdsdsfdsafdsafdsacfdsakljkpsafdsaafdsaajkvckjldskjlf;dsjajfpowejkldsjkfldsakfdjsaklfj" +
								"dsakl;jfdsk;ajkl;dsfajk;lvm;ljfdsakjfdklasjfdsljfdsklajfdsakjfads;kljfdsa;ljfdasljfdsaklfjdaskl;jfds;a" +
								"ljfdk;sljfd;askljfdasljfda;skljfdksljfkdsjfkjkjkjkjklasjfkadsjfkdasjf;adsljfkdsljfdklsjfdk;sljfkl;dsjf" +
								"kldsajklvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv000" +
								"00000000000ddddd3ddddddddddok",
								(j * tmpOneTimeCnt) + i));
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}
				}
				System.out.println("第 "+j+" 次放 "+tmpOneTimeCnt+" 个请求到线程池耗时 "
						+(System.currentTimeMillis() - tmpStartTime));
				
				Thread.sleep(1 * 1000);
			}
			
			Thread.sleep(100000000);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

class Run1 implements Runnable
{
	private String theReq;
	private int index;
	
	public Run1()
	{
		
	}
	
	public Run1(String theReqParm, int indexParm)
	{
		theReq = theReqParm;
		index = indexParm;
	}
	
	@Override
	public void run() {
		try
		{
			Thread.sleep(1);
			TestThread.theGI.addAndGet(1);
			System.out.println("index "+index+"###"+TestThread.theGI.get());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public String getTheReq()
	{
		return theReq;
	}

	public void setTheReq(String theReq)
	{
		this.theReq = theReq;
	}

	public int getIndex()
	{
		return index;
	}

	public void setIndex(int index)
	{
		this.index = index;
	}
	
}
