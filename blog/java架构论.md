我以为用Java适合做架构这事应该是常识了，但是评论中有很多人非常反对这个事。
那我解释一下吧：首先，小型的项目用什么语言都行，爱用什么用什么。
但是，真正的企业级架构就不一样了，其中并不仅仅只是RESTful API或RPC，还有各种配套设施和控制系统，比如：应用网关，服务发现、配置中心、健康检查、服务监控、服务治理（熔断、限流、幂等、重试、隔离、事务补偿）、Tracing监控、SOA/ESB、CQRS、EDA……这些东西在非Java的技术栈体系内，很难看到全貌，Java强大的生态环境，就是让你把注意力放到更高层次的架构和业务上来的。（千万不要觉得，整几个服务RPC一下，加个缓存，加个队列，就能叫架构，那只是系统集成罢了）