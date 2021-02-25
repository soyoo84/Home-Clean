
package homeclean.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name="pay", url="http://localhost:8082")
public interface payHistoryService {

    @RequestMapping(method= RequestMethod.POST, path="/payHistory", consumes = "application/json")
    public void usePoints(@RequestBody payHistory payHistory);
}