package zhangty.cn.com.eventdispatcher.com;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Create by Zhangty on 2018/8/23
 */
public interface Login {

    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("json/reply/AgencyLoginRequest")
    Call<String> postAgencyLogin(@Body RequestBody route);//实现json格式的传输
}
