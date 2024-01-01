     
class Solution:
    def findHighAccessEmployees(self, access_times: List[List[str]]) -> List[str]:
        m = {}
        for e, t in access_times :
            mt = int(t[:2])*60 + int(t[2:])
            m[e] = m.get(e, []) + [mt]
        a = set()
        for e in m:
            ts = m[e]
            if len(ts) < 3:
                continue
            ts.sort()
            for i in range(len(ts) - 2):
                if ts[i+2] - ts[i] < 60:
                    a.add(e)
                    continue
        return a